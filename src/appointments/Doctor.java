package appointments;

public enum Doctor {
   avery("Averios Michael"),
   asim("Muhammad Asim"),
   ali("Ali Mehmood");

   private String name;

   Doctor(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }
}
