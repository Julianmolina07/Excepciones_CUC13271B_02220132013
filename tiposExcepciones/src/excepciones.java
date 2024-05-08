import java.io.*;
import java.sql.*;
public class excepciones {
    //Excepciones irrecolectables:

    // 1.OutOfMemoryError
    public class OutOfMemoryExample {
        public static void main(String[] args) {
            try {
            //Intentamos crear un gran array para consumir toda la memoria disponible
                int[] array = new int[Integer.MAX_VALUE];
            } catch (OutOfMemoryError e) {
                System.out.println("Se ha agotado la memoria");
            }
        }
    }

    //2.StackOverflowError

    public class StackOverflowExample {
        public static void recursiveMethod() {
            recursiveMethod();  //Llamada recursiva infinita
        }
        
        public static void main(String[] args) {
            try {
                recursiveMethod();
            } catch (StackOverflowError e) {
                System.out.println("Desbordamiento de pila");
            }
        }
    }

    //Excepciones que no se necesitan gestionar:

    //1.NullPointerException

    public class NullPointerExceptionExample {
        public static void main(String[] args) {
            String str = null;
            System.out.println(str.length()); //Provoca NullPointerException
        }
    }

    //2.ArrayIndexOutOfBoundsException

    public class ArrayIndexOutOfBoundsExceptionExample {
        public static void main(String[] args) {
            int[] array = new int[5];
            System.out.println(array[5]); //Provoca ArrayIndexOutOfBoundsException
        }
    }

    //3.IllegalArgumentException

    public class IllegalArgumentExceptionExample {
        public static void main(String[] args) {
            int age = -5;
            if (age < 0) {
                throw new IllegalArgumentException("La edad no puede ser negativa");
            }
        }
    }

    //4.ClassCastException

    public class ClassCastExceptionExample {
        public static void main(String[] args) {
            Object obj = new Integer(10);
            String str = (String) obj; //Provoca ClassCastException
        }
    }

    //5.ArithmeticException

    public class ArithmeticExceptionExample {
        public static void main(String[] args) {
            int result = 10 / 0; //Provoca ArithmeticException&& (división por cero)
        }
    }

    //Excepciones necesarias de gestionar:

    //1.IOException

    public class IOExceptionExample {
        public static void main(String[] args) {
            try {
                FileReader file = new FileReader("archivo.txt");
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
            }
        }
    }

    //2.SQLException

    public class SQLExceptionExample {
        public static void main(String[] args) {
            try {
                Connection conn = DriverManager.getConnection("url", "usuario", "contraseña");
            } catch (SQLException e) {
                System.out.println("Error de SQL: " + e.getMessage());
            }
        }
    }

    //3.FileNotFoundException

    public class FileNotFoundExceptionExample {
        public static void main(String[] args) {
            try {
                FileReader file = new FileReader("archivo_que_no_existe.txt");
            } catch (FileNotFoundException e) {
                System.out.println("El archivo no pudo ser encontrado: " + e.getMessage());
            }
        }
    }

    //4.InterruptedException

    public class InterruptedExceptionExample {
        public static void main(String[] args) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("El hilo fue interrumpido");
                }
            });
            
            thread.start();
            thread.interrupt(); //Interrumpir el hilo
        }
    }
    
}