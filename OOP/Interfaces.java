public class Interfaces {
    
    //100% abstraction is used
    //Multiple inheritance can be implemented using interfaces
    // Achieve total abstraction
    //variables in interface are final ,public and static
    //all methods are public ,abstract & without implemetated
    
    public static void main(String[] args) {
        Queen q=new Queen();
        q.moves();
        Ev mix=new Ev();
        mix.sound();
    }
}
    interface ChessPlayer{
        void moves();//default public and abstract
    }

    class Queen implements ChessPlayer{
      public void moves(){
            System.out.println("up,down, left,right, diagonal(in all four direction)");
                }
    }
    class Rook implements ChessPlayer{
        public void moves(){
              System.out.println("up,down, left,right");
                  }
      }
      class King implements ChessPlayer{
        public void moves(){
              System.out.println("up,down, left,right, diagonal(in one direction)");
                }
      }

      //multiple inheritance can be achieved by implementating a class form multiple interfaces
      interface Tesla{
        void sound();
      }
      interface Swift{
        void sound();
      }
      class Ev implements Tesla,Swift{
        public void sound(){
            System.out.println("It is enhanced ev vechile inherited from tesla and Swift car");
        }
      }


