# ----------------------------------------------------------------------------------------
# Writes "Hello, World" to the console using only system calls. Runs on 32-bit Linux only.
# To assemble and run:
#
#     gcc -m32 -c hello-32.s && ld hello-32.o && ./a.out
#
# or
#
#     gcc -m32 -nostdlib hello-32.s && ./a.out
# ----------------------------------------------------------------------------------------

        .global _start

        .text
_start:
        # write(1, message, 13)
        mov     $4, %eax                # system call 4 is write
        mov     $1, %ebx                # file handle 1 is stdout
        mov     $message, %ecx          # address of string to output
        mov     $13, %edx               # number of bytes
        int 	$0x80                   # invoke operating system to do the write

        # exit(0)
        mov     $1, %eax               	# system call 1 is exit
        xor     %ebx, %ebx              # we want return code 0
        int	$0x80                   # invoke operating system to exit
message:
        .ascii  "Hello, world\n"

