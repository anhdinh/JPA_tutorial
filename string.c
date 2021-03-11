#include <stdio.h>

int change_the_name(const char *s)
{
   char *p = s;
   
   
   
   
   //this is a comment

   while (*p)
      ++p;

   return (p - s);
}

int main(void)
{
   int i;
   char *s[] = 
   {
      "Git tutorials",
      "Tutorials Point"
   };

   for (i = 0; i < 2; ++i)
      
   printf("string lenght of %s = %d\n", s[i], change_the_name(s[i]));

   return 0;
}