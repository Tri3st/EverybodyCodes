package exercism.bowling;

public enum FrameType {
        STRIKE("X"),
        SPARE("/"),
        NORMAL(" "),
        NONE("-");

        private final String displayName;
    
        FrameType(String displayName) {
            this.displayName = displayName;
        }
    
        public String getDisplayName() {
            return displayName;
        }
    
        @Override
        public String toString() {
            return displayName;
        }
    }