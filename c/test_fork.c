#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

int i;

int main( void )
{
    pid_t pid;

    printf("pid from parent -> %d\n", getpid());
    pid = fork();
    if (pid == 0)
    {
        i++;
        printf("pid from child -> %d\n", getpid());
        printf("Hello from child process\n");
        exit(0);
    }
    printf("Hello from parent process\n");
    printf("i = %d\n", i);
    wait(NULL);

    return (0);
}