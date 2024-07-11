package dev.jpa.chat;

import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.jpa.chatting.ChatMessage;
import dev.jpa.chatting.ChatRoom;
import dev.jpa.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketHandler extends TextWebSocketHandler {
	
	private final ObjectMapper objectMapper;
	private final ChatService chatService;
	
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

    }

	   @Override
	    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	        String payload = message.getPayload();
	        log.info("{}", payload);
	        System.out.println("hadleTextMessage 들어옴");
	        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
	        System.out.println(chatService.findRoomById(chatMessage.getRoomId()).getName());
	        ChatRoom chatRoom = chatService.findRoomById(chatMessage.getRoomId()); //getRoomId로 채팅방을 찾음
	        

	        chatRoom.handlerActions(session, chatMessage, chatService);
	    }

}
