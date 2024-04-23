package com.capzz.demobackend.consumer;

import com.capzz.demobackend.facade.PagamentoFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PagamentoResponseErroConsumer {

    @Autowired
    PagamentoFacade pagamentoFacade;

    @RabbitListener(queues = {"pagamento-response-erro-queue"})
    public void recebeMensagem(@Payload Message message){

        System.out.println("[" + LocalDateTime.now() + "] Mensagem de erro recebida: " + message);
        String payload = String.valueOf(message.getPayload());

        pagamentoFacade.erroPagamento(payload);

    }

}
