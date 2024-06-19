package my.client.data;

public enum Move {

        PAPER("paper"),
    ROCK("rock"),
        SCISSOR("scissor");

        private String value;

        Move(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
}
