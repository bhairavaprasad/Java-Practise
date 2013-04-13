When a Thread is alive it is in one of several states. On a single-processor system, only thread is actually running at a time.
The other threads are either in blocked or ready-to-run state, waiting for a turn on the processor. ThreadStates.jpg lists various
states an active thread can be in.

The thread scheduler controls which one of the ready-to-run threads is actually running on the processor. Only one thread is actually
in the running state at any given time. All the other threads that are ready-to-run wait to be picked up by the thread scheduler.
Thread priority helps the thread scheduler choose with of the ready-to-run threads should be run next.

Threads can be blocked in one of the four states. When a thread executes Thread.sleep(), it blocks until the specified number of 
milliseconds passes or until it is interrupted by another thread. When a thread encounters a wait() statement, it blocks until it
is notified, interrupted, or the specified number of milliseconds elapses.

There are many ways a thread can block waiting on different I/O methods. One common way is the read() method of InputStream. This
method blocks until a byte of data is read from the stream. It can block indefinitely, and no timeout can be specified.

A thread can also block waiting  to acquire exclusive access to an object's lock. The synchronized statement and synchronized method
modifier are used to control concurrent access by more than one thread to a section of code. A thread will block on synchronized
until it gets the specified lock. It can block indefinitely, and no timeout can be specified.

Notice that not all blocked states are interruptible. When a thread is blocked waiting to read a byte of data from an InputStream, it
will not respond to interrupts. When a thread is blocked waiting to get the lock required by a synchronized statement, it also will
not respond to interrupt requests.

When conditions change and a thread is no longer blocked, the thread moves to the ready-to-run state. It remains there until selected
to run by the thread scheduler. ThreadStateTransitionDiagram.jpg shows how threads transition from one state to another.

Only one thread is actually running at a time, and it eventually blocks, yields, or is forcibly swapped off the processor by the thread
scheduler. If it blocks, it remains blocked until some condition changes. When it finally unblocks, it moves to the ready-to-run state.
When new threads are started they are put in to ready-to-run state.

When the running state is open and there is at least one thread in the ready-to-run state, the thread scheduler chooses one from the
pool of ready-to-run threads and transitions it to the running state. Threads of higher priority are more likely to be chosen than
threads of lower priority, but the exact behavior is dependent on the VM and the operating system.

The Virtual Machine's thread scheduler determines which thread is currently running on the processor and how long it is allowed to run
before being swapped off the processor to allow another thread to run. Thread priorities provide additional information to the thread
scheduler as to which threads are more important to run.

Generally, higher priority threads get more processor time than lower-priority threads.Thread priroties are only a suggestion  to the
thread scheduler and should not be used to guarantee program correctness. Write your program in such a way that they would still
produce correct results regardless of prioritization.

To help ensure that other threads in the VM get a turn to run on the processor, a thread can voluntarily give up its turn early. If
a thread invokes the static method Thread.yield(), the thread scheduler will swap it off the processor and allow another thread to
run. It is likely(but  not guaranteed)  that only threads having a priority equal to or greater than the only that yielded control
will be considered by the thread scheduler.