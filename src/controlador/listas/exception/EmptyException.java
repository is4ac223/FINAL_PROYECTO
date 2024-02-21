package controlador.listas.exception;

public class EmptyException extends Exception{

        public EmptyException() {
        }
        
        public EmptyException(String msg) {
                super(msg);
        }
}
