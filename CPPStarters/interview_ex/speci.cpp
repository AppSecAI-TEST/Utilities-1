template <class N>
void setIncrement(N a){ }; 
 
	template <>
void setIncrement(int n) { }; 
 
	template <>
void setIncrement<int>(int n) { }; 
 
	template <>
void setIncrement<int>(N a){ }; 
 
	template <int>
void setIncrement<>(int n) { }; 
 
	template <int>
void setIncrement<int>(int n) { }; 
 

