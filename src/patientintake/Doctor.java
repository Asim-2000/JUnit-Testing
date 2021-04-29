package patientintake;

public enum Doctor {
   Asim("Muhammad Asim Khaskheli"),
   Ali("Ali Mehmood"),
   Ismail("Muhammad Ismail");

   private String name;

   Doctor(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }
}
