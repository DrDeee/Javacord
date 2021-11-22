package org.javacord.api.entity.channel;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.Messageable;
import org.javacord.api.entity.user.User;
import org.javacord.api.entity.permission.PermissionType;

import java.time.Instant;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface Thread extends TextChannel, Messageable {
    /**
     * Checks if the thread is archived.
     *
     * @return Whether the thread is archived or not.
     */
    boolean isArchived();

    /**
     * Get the timestamp when the archive status of the topic was last changed.
     *
     * @return The date of the last archive change.
     */
    Instant getArchiveTimestamp();

    /**
     * Get the duration in minutes after which the thread is automatically archived after the last activity.
     *
     * @return The auto archive duration in minutes, can be set to 60, 1440, 4320 or 10080.
     */
    int getAutoarchiveDuration();

    /**
     * Check if the thread is locked. Locked threads can be unarchived
     * only with the permission {@link PermissionType#MANAGE_THREADS}.
     *
     * @return Whether the thread is locked or not.
     */
    boolean isLocked();

    /**
     * Check if non-moderators can add other non-moderators to the thread. This is only available on private threads.
     *
     * @return Whether the thread is invitable, only present if the thread is private.
     */
    Optional<Boolean> isInvitable();

    /**
     * Get the ID of the channel where the thread is.
     *
     * @return The ID of the parent channel.
     */
    long getParentChannelId();

    /**
     * Get the ID of the creator of the thread.
     *
     * @return The ID of thread creator.
     */
    long getCreatorId();

    /**
     * Get the message, the thread was started from.
     *
     * @return Optional containing the message, the thread was started from. If empty, the message was deleted.
     */
    Optional<Message> getStartMessage();

    /**
     * Get a collection with all users who joined the thread.
     *
     * @return A collection with all members of the thread.
     */
    Collection<User> getMembers();

    /**
     * Lock the thread. Locked threads can be unarchived
     * only with the permission {@link PermissionType#MANAGE_THREADS}.
     *
     * @return A future to check if the locking was successful.
     */
    CompletableFuture<Void> lockThread();

    /**
     * Lock the thread with a reason. Locked threads can be unarchived
     * only with the permission {@link PermissionType#MANAGE_THREADS}.
     *
     * @param reason The reason shown in the audit log
     * @return A future to check if locking was successful.
     */
    CompletableFuture<Void> lockThread(String reason);

    /**
     * Join the thread.
     * @return A future to check if joining was successful.
     */
    CompletableFuture<Void> join();

    /**
     * Leave the thread.
     * @return A future to check if leaving was successful.
     */
    CompletableFuture<Void> leave();

    /**
     * Add a member to the thread. Requires the ability to send messages in the thread and that the
     * thread is not archived.
     * @param user The user you want to add.
     * @return A future to check if adding (or the user was already in the thread) was successful.
     */
    CompletableFuture<Void> addMember(User user);

    /**
     * Add a member to the thread. Requires the ability to send messages in the thread and that the
     * thread is not archived.
     * @param userId The ID of the user you want to add.
     * @return A future to check if adding (or the user was already in the thread) was successful.
     */
    CompletableFuture<Void> addMember(long userId);

    /**
     * Remove a member from the thread. Requires the {@link PermissionType#MANAGE_THREADS} permission.
     * @param user The user you want to remove.
     * @return A future to check if removing was successful.
     */
    CompletableFuture<Void> removeMember(User user);

    /**
     * Remove a member from the thread. Requires the {@link PermissionType#MANAGE_THREADS} permission.
     * @param userId The ID of the user you want to remove.
     * @return A future to check if removing was successful.
     */
    CompletableFuture<Void> removeMember(long userId);
}
