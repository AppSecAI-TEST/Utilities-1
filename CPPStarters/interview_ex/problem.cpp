#include <iostream>

using namespace std;
class Channel {
public:
    static int connections;
};

int Channel::connections = 0;

class PriorityChannel : public Channel {

};

class NormalChannel : public Channel {

};

Channel          ch;
NormalChannel    chn1;
PriorityChannel  chn2;

PriorityChannel  &cref = chn2;
 
int getLength()
{
    return 10;
}


int main() 
{
chn2.connections++;
cref::connections++;
Channel.connections++;
ch.connections++;
NormalChannel::connections++;


int numerator, denominator;

{
numerator = 10.0;
denominator = 3.0;
float quotient = numerator / denominator;

cout << quotient;

const int size = 10;
char message[size]; 
}
/* 
for(char idx=0; idx<250; idx++)
{
    cout << "hello world" << endl;
} */
{    
int size = getLength();
char message[size]; 
}

};

