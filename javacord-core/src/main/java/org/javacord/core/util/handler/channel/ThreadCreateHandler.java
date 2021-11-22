package org.javacord.core.util.handler.channel;

import com.fasterxml.jackson.databind.JsonNode;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.ServerVoiceChannel;
import org.javacord.api.entity.channel.Thread;
import org.javacord.api.event.channel.server.ServerChannelCreateEvent;
import org.javacord.core.DiscordApiImpl;
import org.javacord.core.entity.ThreadImpl;
import org.javacord.core.entity.server.ServerImpl;
import org.javacord.core.entity.user.UserImpl;
import org.javacord.core.event.channel.server.ServerChannelCreateEventImpl;
import org.javacord.core.util.event.DispatchQueueSelector;
import org.javacord.core.util.gateway.PacketHandler;

public class ThreadCreateHandler extends PacketHandler {
    public ThreadCreateHandler(DiscordApiImpl api) {
        super(api, true, "THREAD_CREATE");
    }

    @Override
    protected void handle(JsonNode channel) {
        System.out.println(channel.toString());
        long serverId = channel.get("guild_id").asLong();
        api.getPossiblyUnreadyServerById(serverId).ifPresent(server -> {
            Thread t = new ThreadImpl(api, (ServerImpl) server, channel);
            System.out.println(t.isArchived() + " " + t.getCreatorId());
        });

    }
}
