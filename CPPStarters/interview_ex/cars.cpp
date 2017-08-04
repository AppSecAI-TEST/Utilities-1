#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <cassert>

/*
Implement the following car hierarchy along with the accessor functions
and a CarRental class which contains the container to store them.

A car rental company wants to keep track of its cars. Each vehicle has a
license plate and a brand. (eg. BWM). Currently the company has SUVs and
Sedans. SUV-s have an optional third row seat that increases the
passenger capacity by three, sedans have an optional sport package. Each
car can be queried to inquire the number of passengers it can carry.
*/

/* to compile: g++ -std=c++11 -o cars
   to run: ./cars
*/

class Car
{
    std::string m_license_plate;
    std::string m_brand;

    const int SUVplaces=5+3;
    const int SEDANplaces=5;

public:
    enum CarType
    {
        SUV,
        SEDAN
    };

private:
    CarType m_car_type;
    int m_places;

public:

    std::string get_license_plate() {
        return m_license_plate;
    };
    std::string get_brand() {
        return m_brand;
    };
    CarType get_car_type() {
        return m_car_type;
    };

    void set_license_plate(const std::string & license_plate)
    {
        m_license_plate = license_plate;
    };

    void set_brand(const std::string & brand) {
        m_brand = brand;
    };

    void set_car_type(const CarType & car_type)
    {
        m_car_type = car_type;
        if(car_type==SUV)
            m_places=SUVplaces;
        else if(car_type==SEDAN)
            m_places=SEDANplaces;
    }

    Car(CarType car_type, std::string license_plate, std::string brand) :
        m_license_plate{license_plate}, m_brand{brand}
    {
        set_car_type(car_type);
    }

    // return places;
    int query()
    {
        return m_places;
    }

};

typedef std::vector<Car> CarRental;

int main()
{
    /* */

    Car::CarType car_type;
    std::string license_plate;
    std::string brand;

    CarRental carRental = {Car(Car::SEDAN,"00001","Mercedes"),
                           Car(Car::SEDAN,"00002","BMW"),Car(Car::SUV,"00003","Audi"),
                           Car(Car::SUV,"00004","BMW"),Car(Car::SUV,"00005","Mercedes")
                          };

    car_type = Car::SUV;
    license_plate = "1111";
    brand = "Mercedes";

    carRental.push_back(Car(car_type, license_plate, brand));

    int accumulator=0;

    // count all Mercedes places
    std::for_each(carRental.begin(),carRental.end(),
                  [&accumulator](Car &car)
    {
        if(car.get_brand()=="Mercedes") accumulator+=car.query();
    });

    assert(accumulator==21);
    std::cout << "Mercedes places:" << accumulator << std::endl;

    accumulator = 0;

    // count all with numbers from 2 to 5
    for_each(carRental.begin(),carRental.end(),
             [&accumulator](Car &car)
    {
        if(car.get_license_plate()>="00002"
                && car.get_license_plate()<="00005") accumulator+=car.query();
    });

    assert(accumulator==29);
    std::cout << "license plate between 00002 and 00005 places:" <<
              accumulator << std::endl;

    accumulator = 0;
    // count all Mercedes SUV
    for_each(carRental.begin(),carRental.end(),
             [&accumulator](Car &car)
    {
        if(car.get_brand()=="Mercedes"
                && car.get_car_type()==Car::SUV) accumulator+=car.query();
    });

    assert(accumulator==16);
    std::cout << "Mercedes SUV places:" << accumulator << std::endl;

    return 0;
}

