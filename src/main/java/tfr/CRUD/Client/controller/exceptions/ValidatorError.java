package tfr.CRUD.Client.controller.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidatorError extends CustomError{

   private List<FieldMessage> erros = new ArrayList<>();
    public ValidatorError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

   public void addErros(String fieldName, String fieldMessage){
        erros.add(new FieldMessage(fieldName,fieldMessage));
   }
}
