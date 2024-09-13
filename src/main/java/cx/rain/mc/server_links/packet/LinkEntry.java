package cx.rain.mc.server_links.packet;

import com.comphenix.protocol.wrappers.*;
import cx.rain.mc.server_links.config.LinkType;

public record LinkEntry(Either<LinkType, WrappedChatComponent> type, String url) {
}
