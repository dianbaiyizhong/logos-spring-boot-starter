
package com.github.nntk.elfinder.configuration.jaxb;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class ElfinderConfiguration {

    protected ElfinderConfiguration.Thumbnail thumbnail;

    public void setVolume(List<Volume> volume) {
        this.volume = volume;
    }

    protected List<ElfinderConfiguration.Volume> volume;

    /**
     * Gets the value of the thumbnail property.
     *
     * @return possible object is
     * {@link ElfinderConfiguration.Thumbnail }
     */
    public ElfinderConfiguration.Thumbnail getThumbnail() {
        return thumbnail;
    }

    /**
     * Sets the value of the thumbnail property.
     *
     * @param value allowed object is
     *              {@link ElfinderConfiguration.Thumbnail }
     */
    public void setThumbnail(ElfinderConfiguration.Thumbnail value) {
        this.thumbnail = value;
    }

    /**
     * Gets the value of the volume property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the volume property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVolume().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElfinderConfiguration.Volume }
     */
    public List<ElfinderConfiguration.Volume> getVolume() {
        if (volume == null) {
            volume = new ArrayList<ElfinderConfiguration.Volume>();
        }
        return this.volume;
    }


    public static class Thumbnail {

        protected BigInteger width;

        /**
         * Gets the value of the width property.
         *
         * @return possible object is
         * {@link BigInteger }
         */
        public BigInteger getWidth() {
            return width;
        }

        /**
         * Sets the value of the width property.
         *
         * @param value allowed object is
         *              {@link BigInteger }
         */
        public void setWidth(BigInteger value) {
            this.width = value;
        }

    }


    public static class Volume {

        protected String source;
        protected String alias;
        protected String path;
        protected Boolean _default;
        protected String locale;
        protected ElfinderConfiguration.Volume.Constraint constraint = new Constraint();

        /**
         * Gets the value of the source property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getSource() {
            return source;
        }

        /**
         * Sets the value of the source property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setSource(String value) {
            this.source = value;
        }

        /**
         * Gets the value of the alias property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getAlias() {
            return alias;
        }

        /**
         * Sets the value of the alias property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setAlias(String value) {
            this.alias = value;
        }

        /**
         * Gets the value of the path property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPath() {
            return path;
        }

        /**
         * Sets the value of the path property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPath(String value) {
            this.path = value;
        }

        /**
         * Gets the value of the default property.
         *
         * @return possible object is
         * {@link Boolean }
         */
        public Boolean isDefault() {
            return _default;
        }

        /**
         * Sets the value of the default property.
         *
         * @param value allowed object is
         *              {@link Boolean }
         */
        public void setDefault(Boolean value) {
            this._default = value;
        }

        /**
         * Gets the value of the locale property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getLocale() {
            return locale;
        }

        /**
         * Sets the value of the locale property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setLocale(String value) {
            this.locale = value;
        }

        /**
         * Gets the value of the constraint property.
         *
         * @return possible object is
         * {@link ElfinderConfiguration.Volume.Constraint }
         */
        public ElfinderConfiguration.Volume.Constraint getConstraint() {
            return constraint;
        }

        /**
         * Sets the value of the constraint property.
         *
         * @param value allowed object is
         *              {@link ElfinderConfiguration.Volume.Constraint }
         */
        public void setConstraint(ElfinderConfiguration.Volume.Constraint value) {
            this.constraint = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;all&gt;
         *         &lt;element name="locked" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *         &lt;element name="readable" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *         &lt;element name="writable" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *       &lt;/all&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         */

        public static class Constraint {

            protected boolean locked = true;
            protected boolean readable = true;
            protected boolean writable = true;

            /**
             * Gets the value of the locked property.
             */
            public boolean isLocked() {
                return locked;
            }

            /**
             * Sets the value of the locked property.
             */
            public void setLocked(boolean value) {
                this.locked = value;
            }

            /**
             * Gets the value of the readable property.
             */
            public boolean isReadable() {
                return readable;
            }

            /**
             * Sets the value of the readable property.
             */
            public void setReadable(boolean value) {
                this.readable = value;
            }

            /**
             * Gets the value of the writable property.
             */
            public boolean isWritable() {
                return writable;
            }

            /**
             * Sets the value of the writable property.
             */
            public void setWritable(boolean value) {
                this.writable = value;
            }

        }

    }

}
