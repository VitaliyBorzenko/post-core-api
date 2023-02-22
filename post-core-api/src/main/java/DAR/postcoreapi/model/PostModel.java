package DAR.postcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class PostModel {
  //  @NotNull(message = "postId can not be empty")
    private String postId; //ID посылки
  //  @NotNull(message = "clientId can not be empty")
    private String clientId; //ID клиента
  //  @NotNull(message = "postRecipientId can not be empty")
    private String postRecipientId; //ID получателя
    private String postItem; //Наименование посылки
    private String status; //Статус заказа


}
