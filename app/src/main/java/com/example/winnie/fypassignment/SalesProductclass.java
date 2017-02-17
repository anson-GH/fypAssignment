package com.example.winnie.fypassignment;

import java.io.Serializable;

/**
 * Created by Winnie on 15/2/2017.
 */


    public class SalesProductclass  implements Serializable {

        private String item;

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }
    }
