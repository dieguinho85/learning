package nestedandinnerclasses.nested;

public class Oyster {
    public class Pearl{
        String pearl="member";
        private String privatePearl="private member";
        protected String protectedPearl="protected member";
        public String publicPearl="public member";

        public Pearl() {
            oyster="sdfsds";             // OK!
            privateOyster="sdcdscs";     // OK!
            protectedOyster="svsfdf";    // OK!
            publicOyster="sdfdfsd";      // OK!
        }
    }

    String oyster="member";
    private String privateOyster="private member";
    protected String protectedOyster="protected member";
    public String publicOyster="public member";

    public Oyster(){
        /*
        pearl="sddsfsd";                // not OK!
        privatePearl="sdfdfdfs";        // not OK!
        protectedPearl="svsfdf";        // not OK!
        publicPearl="sdfdfsd";          // not OK!
         */
    }
}