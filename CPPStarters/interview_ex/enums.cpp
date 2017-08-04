enum DAY{ Mon = 11, Tue = 12 };

int main(){

{	enum DAY var = dynamic_cast<enum DAY>(Mon);
}{	enum DAY var = DAY.Mon;
}{	enum DAY var = DAY::Mon;
}{	enum DAY var = Mon;
}{	DAY var = DAY::Mon;
}
}
