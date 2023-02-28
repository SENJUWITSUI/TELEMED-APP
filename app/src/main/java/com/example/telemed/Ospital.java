package com.example.telemed;

public class Ospital {
        private String title, number;
        private int resourceId;


        public Ospital(int resourceId, String title, String number){
            this.resourceId = resourceId;
            this.title = title;
            this.number = number;
        }

        public int getResourceId() {return resourceId;}


        public void setResourceId(int resourceId) {
            this.resourceId = resourceId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNumber() {
        return number;
    }

        public void setNumber(String number) {
        this.number = number;
    }
    }


