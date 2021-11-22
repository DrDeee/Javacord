package org.javacord.core.entity;

import com.fasterxml.jackson.databind.JsonNode;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.Thread;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.user.User;
import org.javacord.core.DiscordApiImpl;
import org.javacord.core.entity.channel.ServerTextChannelImpl;
import org.javacord.core.entity.server.ServerImpl;

import java.time.Instant;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ThreadImpl extends TextChannel implements Thread {
    private volatile boolean archived;
    private volatile Instant archiveTs;
    private volatile int autoarchiveDuration;
    private volatile boolean locked;
    private volatile Optional<Boolean> isInvitable;
    private volatile long parentChannelId;

    private volatile long creatorId;

    /**
     * Creates a new thread object.
     *
     * @param api    The discord api instance.
     * @param server The server of the channel.
     * @param data   The json data of the channel.
     */
    public ThreadImpl(DiscordApiImpl api, ServerImpl server, JsonNode data) {
        JsonNode meta = data.get("thread_metadata");
        archived = meta.get("archived").asBoolean();
        archiveTs = Instant.parse(meta.get("archive_timestamp").asText());
        autoarchiveDuration = meta.get("auto_archive_duration").asInt();
        locked = meta.get("locked").asBoolean();
        isInvitable = meta.has("invitable") ?
                Optional.of(meta.get("invitable").asBoolean()) :
                Optional.empty();
        parentChannelId = data.get("parent_id").asLong();
        creatorId = data.get("owner_id").asLong();
    }

    @Override
    public boolean isArchived() {
        return archived;
    }

    @Override
    public Instant getArchiveTimestamp() {
        return archiveTs;
    }

    @Override
    public int getAutoarchiveDuration() {
        return autoarchiveDuration;
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public Optional<Boolean> isInvitable() {
        return isInvitable;
    }

    @Override
    public long getParentChannelId() {
        return parentChannelId;
    }

    @Override
    public long getCreatorId() {
        return creatorId;
    }

    @Override
    public Optional<Message> getStartMessage() {
        return Optional.empty();
    }

    @Override
    public Collection<User> getMembers() {
        return null;
    }

    @Override
    public CompletableFuture<Void> lockThread() {
        return null;
    }

    @Override
    public CompletableFuture<Void> lockThread(String reason) {
        return null;
    }

    @Override
    public CompletableFuture<Void> join() {
        return null;
    }

    @Override
    public CompletableFuture<Void> leave() {
        return null;
    }

    @Override
    public CompletableFuture<Void> addMember(User user) {
        return null;
    }

    @Override
    public CompletableFuture<Void> addMember(long userId) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeMember(User user) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeMember(long userId) {
        return null;
    }
}
