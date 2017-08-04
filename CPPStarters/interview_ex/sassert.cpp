
template<typename T>
void processCollection(T t)
{
    static_assert(std::is_empty<T>::value, "collection is empty");    // Line 1

    //...

};

int main()
{
    std::vector<int> ages;

    //...
        
    processCollection<std::vector<int>>(ages);    // Line 2
}

