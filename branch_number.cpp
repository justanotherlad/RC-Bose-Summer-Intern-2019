#include <algorithm>
#include <climits>
#include <cmath>
#include <iostream>
#include <map>
#include <set>
#include <string>
#include <vector>

// author:Swastik Banerjee

using namespace std;

typedef long long ll;

typedef uint8_t byte;

const byte min_poly = 0b11101;

byte gal_mul(byte c, byte d) {
  byte res = 0;
  for (; d; d >>= 1) {
    if (d & 1) res ^= c;
    if (c & 0x80)
      c = (c << 1) ^ min_poly;
    else
      c <<= 1;
  }
  return res;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);

#ifndef ONLINE_JUDGE
  FILE *f1 = freopen("input.txt", "r", stdin);
  FILE *f2 = freopen("output.txt", "w", stdout);
#endif

  byte a[4][4];
  for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 4; j++) {
      cin >> a[i][j];
    }
  }
  byte x0, x1, x2, x3;
  byte y[4] = {0, 0, 0, 0};
  int v = 8;

  for (x0 = 1; x0 < 256; x0++) {
    for (x1 = 1; x1 < 256; x1++) {
      for (x2 = 1; x2 < 256; x2++) {
        for (x3 = 1; x3 < 256; x3++) {
          for (int j = 0; j < 4; j++) {
            y[j] = gal_mul(a[j][0], x0) ^ gal_mul(a[j][1], x1) ^
                   gal_mul(a[j][2], x2) ^ gal_mul(a[j][3], x3);
          }
          int p0 = 0;

          if (x0 > 0) p0++;
          if (x1 > 0) p0++;
          if (x2 > 0) p0++;
          if (x3 > 0) p0++;
          if (y[0] > 0) p0++;
          if (y[1] > 0) p0++;
          if (y[2] > 0) p0++;
          if (y[3] > 0) p0++;
          if (p0 < v) v = p0;
        }
      }
    }
  }
  cout << v << endl;
}
