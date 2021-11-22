package org.javacord.api.event.channel.thread;

import org.javacord.api.listener.GloballyAttachableListener;
import org.javacord.api.listener.channel.ChannelAttachableListener;
import org.javacord.api.listener.message.MessageAttachableListener;
import org.javacord.api.listener.server.ServerAttachableListener;

public interface ThreadCreateEvent extends GloballyAttachableListener, ServerAttachableListener,
        ChannelAttachableListener, MessageAttachableListener {

    /**
     * Get the created thread.
     * @return The created thread.
     */
    Thread getThread();
}
