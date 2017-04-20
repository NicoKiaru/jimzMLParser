package com.alanmrace.jimzmlparser.mzml;

/**
 * BinaryDataArrayList tag.
 *
 * @author Alan Race
 */
public class BinaryDataArrayList extends MzMLContentList<BinaryDataArray> {

    /**
     * Serialisation version ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new binaryDataArrayList tag.
     *
     * @param count the size of the list
     */
    public BinaryDataArrayList(int count) {
        super(count);
    }

    /**
     * Copy constructor.
     *
     * @param bdaList Old BinaryDataArrayList to copy
     * @param rpgList New ReferenceableParamGroupList to match references to
     * @param dpList New DataProcessingList to match references to
     */
    public BinaryDataArrayList(BinaryDataArrayList bdaList, ReferenceableParamGroupList rpgList, DataProcessingList dpList) {
        this(bdaList.size());

        for (BinaryDataArray bda : bdaList) {
            this.add(new BinaryDataArray(bda, rpgList, dpList));
        }
    }

    /**
     * Returns the BinaryDataArray which contains the CVParam 
     * {@link BinaryDataArray#mzArrayID}, or null if one is not present within the 
     * list.
     * 
     * @return m/z BinaryDataArray, or null if not found
     */
    public BinaryDataArray getmzArray() {
        BinaryDataArray mzArray = null;

        for (BinaryDataArray binaryDataArray : list) {
            if (binaryDataArray.ismzArray()) {
                mzArray = binaryDataArray;
                break;
            }
        }

        return mzArray;
    }

    /**
     * Returns the BinaryDataArray which contains the CVParam 
     * {@link BinaryDataArray#intensityArrayID}, or null if one is not present within the 
     * list.
     * 
     * @return Intensity BinaryDataArray, or null if not found
     */
    public BinaryDataArray getIntensityArray() {
        BinaryDataArray intensityArray = null;

        for (BinaryDataArray binaryDataArray : list) {
            if (binaryDataArray.isIntensityArray()) {
                intensityArray = binaryDataArray;
                break;
            }
        }

        return intensityArray;
    }

    /**
     * Add BinaryDataArray. Helper method to retain API, calls 
     * {@link BinaryDataArrayList#add(com.alanmrace.jimzmlparser.mzml.MzMLTag)}.
     * 
     * @param bda BinaryDataArray to add to list
     */
    public void addBinaryDataArray(BinaryDataArray bda) {
        add(bda);
    }

    /**
     * Returns BinaryDataArray at specified index in list. Helper method to retain 
     * API, calls {@link BinaryDataArrayList#get(int)}.
     * 
     * @param index Index in the list
     * @return BinaryDataArray at index, or null if none exists
     */
    public BinaryDataArray getBinaryDataArray(int index) {
        return get(index);
    }

    @Override
    public String getTagName() {
        return "binaryDataArrayList";
    }
}
