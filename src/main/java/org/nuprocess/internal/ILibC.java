package org.nuprocess.internal;

import java.nio.Buffer;

import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

public interface ILibC
{
    int pipe(int[] fildes);

    int fcntl(int fildes, int cmd);

    int fcntl(int fildes, int cmd, long argO);

    int close(int fildes);

    int write(int fildes, Buffer buf, int nbyte);

    int read(int fildes, Buffer buf, int nbyte);

    int kill(int pid, int sig);

    int waitpid(int pid, IntByReference status, int options);

    int posix_spawnattr_init(Pointer posix_spawnattr_t);

    int posix_spawnattr_destroy(Pointer posix_spawnattr_t);

    int posix_spawnattr_setflags(Pointer posix_spawnattr_t, short flags);

    int posix_spawn_file_actions_init(PointerByReference posix_spawn_file_actions_t);

    int posix_spawn_file_actions_destroy(PointerByReference posix_spawn_file_actions_t);

    int posix_spawn_file_actions_addclose(PointerByReference actions, int filedes);

    int posix_spawn_file_actions_adddup2(PointerByReference actions, int fildes, int newfildes);

    int posix_spawn_file_actions_addinherit_np(PointerByReference actions, int filedes);

    int posix_spawn(IntByReference restrict_pid, String restrict_path, PointerByReference file_actions,
                    Pointer /*const posix_spawnattr_t*/ restrict_attrp, StringArray /*String[]*/ argv, Pointer /*String[]*/ envp);

    // from /usr/include/sys/spawn.h
    short POSIX_SPAWN_START_SUSPENDED = 0x0080;
    short POSIX_SPAWN_CLOEXEC_DEFAULT = 0x4000;

    // From /usr/include/sys/signal.h
    int SIGTERM = 15;
    int SIGCONT = 19;
}
