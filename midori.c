#include <stdio.h>
int i, j, r;
const int ROUNDS = 5; /* number of rounds */
int next = 0;         /* next unused state variable index */
int dummy = 0;        /* next unused dummy variable index */
void ShuffleCell(int a[4][4]) {
  int tmp[4][4];

  tmp[0][0] = a[0][0];
  tmp[1][0] = a[2][2];
  tmp[2][0] = a[1][1];
  tmp[3][0] = a[3][3];
  tmp[0][1] = a[2][3];
  tmp[1][1] = a[0][1];
  tmp[2][1] = a[3][2];
  tmp[3][1] = a[1][0];
  tmp[0][2] = a[1][2];
  tmp[1][2] = a[3][0];
  tmp[2][2] = a[0][3];
  tmp[3][2] = a[2][1];
  tmp[0][3] = a[3][1];
  tmp[1][3] = a[1][3];
  tmp[2][3] = a[2][0];
  tmp[3][3] = a[0][2];

  for (int j = 0; j < 4; j++) {
    for (int i = 0; i < 4; i++) {
      a[i][j] = tmp[i][j];
    }
  }
}

void MixColumn(int a[4][4]) {
  for (j = 0; j < 4; j++) {
    for (i = 0; i < 4; i++) printf("x%i + ", a[i][j]);
    for (i = 0; i < 3; i++) printf("x%i + ", next + i);
    printf("x%i - 4 d%i >= 0\n", next + 3, dummy);

    for (i = 0; i < 4; i++) printf("d%i - x%i >= 0\n", dummy, a[i][j]);
    for (i = 0; i < 4; i++) printf("d%i - x%i >= 0\n", dummy, a[i][j] = next++);
    dummy++;
  }
}

int main() {
#ifndef ONLINE_JUDGE
  FILE *f1 = freopen("input.txt", "r", stdin);
  FILE *f2 = freopen("midori.lp", "w", stdout);
#endif

  int a[4][4]; /* the bytes of the AES state */
  for (i = 0; i < 4; i++)
    for (j = 0; j < 4; j++) a[i][j] = next++; /* initialize variable indices */

  printf("Minimize\n"); /* print objective function */

  for (i = 0; i < ROUNDS * 16 - 1; i++) printf("x%i + ", i);
  printf("x%i\n\n", ROUNDS * 16 - 1);

  printf("Subject To\n"); /* round function constraints */
  for (r = 0; r < ROUNDS; r++) {
    ShuffleCell(a);
    MixColumn(a);
    /* at least one S-box must be active */
    for (i = r * 16; i < r * 16 + 15; i++) printf("x%i + ", i);
    printf("x%i >= 1\n\n", r * 16 + 15);
  }

  printf("Binary\n"); /* binary constraints */
  for (i = 0; i < 16; i++) printf("x%i\n", i);
  for (i = 0; i < dummy; i++) printf("d%i\n", i);
  printf("End\n");
  return 0;
}