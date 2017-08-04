/* Copyright 2016, Roman Gritsulyak. Any distribution is not allowed
   without Authors permit.
 */

#ifndef _OBJECTPOOL_
#define _OBJECTPOOL_
#include <memory>
#include <cstddef>
#include <cstdlib>
#include <thread>
#include <mutex>

template<std::size_t MAX_OBJ_SIZE>
class pool
{
public:
    /** \brief  constructor of pool
     *
     * \param  maxCapacity - max capacity of elements in pool, amount allocated
     * \param  minCapacity - min capacity of elements in pool, when less objects
     * than max left in pool, additionally allocated (max-min) elements
     * \return since it is constructor, it doesn't return anything
     *
     */
    pool (std::size_t maxCapacity_, std::size_t minCapacity_): maxCapacity{maxCapacity_}, minCapacity{minCapacity_}, usedBytes{0}
    {
        memory = (char*)std::calloc(maxCapacity, MAX_OBJ_SIZE);
    };

    /** \brief allocs required amount of objects in pool
     *
     * \param  object - object to allocate
     * \param  args - reserved for future use
     * \return
     *
     */
    template<typename OBJECT, typename ... ARGS>
    void alloc (std::shared_ptr<OBJECT> & object, ARGS ... args)
    {
        object = std::make_shared<OBJECT>(*(reinterpret_cast<OBJECT*>
                                          (memory + usedBytes)));
        usedBytes+=sizeof(object);
    };

private:
    // MUTEXED_BLOCK
    std::mutex memory_mutex;
    char * memory; // allocated space
    int64_t usedBytes; // -> pointer to current block
    // END MUTEXED_BLOCK

    // max--> if < min => add memory up to max
    std::size_t maxCapacity; // capacity of free space after fall below
    std::size_t minCapacity; // minCapacity
};

#endif

