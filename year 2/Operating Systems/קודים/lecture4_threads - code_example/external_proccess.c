#include <sys/ipc.h>
#include <sys/types.h>
#include <sys/msg.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define CENTRAL_MAILBOX 1200    //Central Mailbox number

struct {
long priority;        //message priority
int temp;            //temperature
int pid;               //process id
int stable;          //boolean for temperature stability
} msgp, cmbox;

//MAIN function
int main(int argc, char *argv[]) {

   /* Validate that a temperature and a Unique 
       process ID was given via the command  */
   if(argc != 3) {
      printf("USAGE: Too few arguments --./central.out Temp UID");
      exit(0);
   }

   //Setup local variables
   int unstable = 1;
   int result, length, status;
   int initTemp = atoi(argv[1]);
   int uid = atoi(argv[2]);

   //Create the Central Servers Mailbox
   int msqidC = msgget(CENTRAL_MAILBOX, 0600 | IPC_CREAT);

   //Create the mailbox for this process and store it's IDs
   int msqid = msgget((CENTRAL_MAILBOX + uid), 0600 | IPC_CREAT);

   //Initialize the message to be sent
   cmbox.priority = 1;
   cmbox.pid = uid;
   cmbox.temp = initTemp;
   cmbox.stable = 1;

   /* The length is essentially the size of 
       the structure minus sizeof(mtype) */
   length = sizeof(msgp) - sizeof(long);

   //While all the processes have different temps
   while(unstable == 1){
      //Send the current temp to the central server
      result = msgsnd( msqidC, &cmbox, length, 0);

      //Wait for a new message from the central server
      result = msgrcv( msqid, &msgp, length, 1, 0);

      //If the new message indicates all the processes have the same temp
      //break the loop and print out the final temperature
      if(msgp.stable == 0) {
         unstable = 0;
         printf("\nProcess %d Temp: %d\n", cmbox.pid, cmbox.temp);
      }
      else { //otherwise calculate the new temp and store it
         int newTemp = (cmbox.temp * 3 + 2 * msgp.temp) / 5;
         cmbox.temp = newTemp;
      }
   }

   //Remove the mailbox
   status = msgctl(msqid, IPC_RMID, 0);

   //Validate nothing when wrong when trying to remove mailbox
   if(status != 0){
      printf("\nERROR closing mailbox\n");
   }
}