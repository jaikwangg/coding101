#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#include <unistd.h>

int sum;
void 

void *runner(void *param)
{
    i++;
    printf("Hello from thread\n");
    printf("pid from thread -> %d\n", getpid());
    return (NULL);
}

int main( void )
{
    pthread_t tid;
    pthread_attr attr

    printf("pid from main -> %d\n", getpid());
    pthread_create(&t, NULL, runner, NULL);
    printf("Hello from main\n");
    pthread_join(t, NULL);
    printf("i = %d\n", i);
    return (0);
}