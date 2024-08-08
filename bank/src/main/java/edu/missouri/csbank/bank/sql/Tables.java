package edu.missouri.csbank.bank.sql;


public enum Tables {


        PERSONAL_INFO("PersonalInfo");




        private final String name;
        Tables(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }



}
