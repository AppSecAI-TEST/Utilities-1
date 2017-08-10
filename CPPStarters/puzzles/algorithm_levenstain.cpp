#include <vector>
#include <algorithm>
#include <string>
#include <iostream>

template <typename T>
void dump(std::vector< std::vector<typename T::size_type> > vectorDump) {
    int m = vectorDump.size();
    int n = vectorDump[0].size();
    
      for (typename T::size_type i = 0; i < m; ++i) {
        for(typename T::size_type j = 0; j < n; ++j) {
            std::cout << "{" << vectorDump[i][j] << "}";
        }
        std::cout << std::endl;
      }
    
};

template <typename T>
typename T::size_type levenshtein_distance(const T & src, const T & dst) {
  const typename T::size_type m = src.size();
  const typename T::size_type n = dst.size();
  if (m == 0) {
    return n;
  }
  if (n == 0) {
    return m;
  }

  std::vector< std::vector<typename T::size_type> > matrix(m + 1);

  for (typename T::size_type i = 0; i <= m; ++i) {
    matrix[i].resize(n + 1);
    matrix[i][0] = i;
  }
  for (typename T::size_type i = 0; i <= n; ++i) {
    matrix[0][i] = i;
  }

  std::cout << "after initialization" << std::endl;  
  dump<T>(matrix);

  typename T::size_type above_cell, left_cell, diagonal_cell, cost;

  for (typename T::size_type i = 1; i <= m; ++i) {
    for(typename T::size_type j = 1; j <= n; ++j) {
      cost = src[i - 1] == dst[j - 1] ? 0 : 1;
      above_cell = matrix[i - 1][j];
      left_cell = matrix[i][j - 1];
      diagonal_cell = matrix[i - 1][j - 1];
      matrix[i][j] = std::min(std::min(above_cell + 1, left_cell + 1), diagonal_cell + cost);
      std::cout << "inside loop viaualization" << std::endl;
      dump<T>(matrix);
    }
  }

  return matrix[m][n];
}


int main(){

std::string start = "Pass";
std::string end = "Octopussy";

int size = levenshtein_distance(start, end);

std::cout << "size=" << size;

}


