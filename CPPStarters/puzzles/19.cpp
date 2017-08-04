#include <iostream>
#include <vector>

using namespace std;

/* You are given the following information, 
but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, 
but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during 
the twentieth century (1 Jan 1901 to 31 Dec 2000)? */

// return 0 - sunday 6 -saturday
// 1-30, 1-12,1900-20xx
int days_in_month(int month, int year){
  static vector<int> months{31,28,31,30,31,30,31,31,30,31,30,31}; 
  // {1,1,1900} =1;
  int ret = months[month-1];
  if(month==1) // february
  {
    if(year%4 && !(year%400))
      ret++;
  }  
  return ret; 
}

int main()
{
  auto weekday=1;
  auto suns_on_first=0;

  for(auto year=1900;year<=2000;year++)
    for(auto month=1;month<=12;month++)
      for(auto day=1;day<=days_in_month(month,year);day++)
      {
         if(year>1900 && day==1 && weekday==0)
	   suns_on_first++;
         weekday=(weekday+1)%7;
      }

  cout << "suns:" << suns_on_first << endl;

  return 0;
}

