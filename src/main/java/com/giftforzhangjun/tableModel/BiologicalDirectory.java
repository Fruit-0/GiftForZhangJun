package com.giftforzhangjun.tableModel;

import java.util.Objects;

/**
 * @author 冲动火龙果
 * @version 1.0.0
 * @ClassName BiologicalDirectory.java
 * @Description 生物名录表 实体类映射
 * @createTime 2023年09月09日 20:36:00
 */
public class BiologicalDirectory {
   
    private Integer pk;
      String kingdomCn;
      String kingdomLatin;
      String phylumCn;
      String phylumLatin;
      String classCn;
      String classLatin;
      String orderCn;
      String orderLatin;
      String familyCn;
      String familyLatin;
      String genusCn;
      String genusLatin;
      String speciesCn;
      String speciesLatin;
      String auditor;
      String directoryVersion;
    
    
    public BiologicalDirectory() {
    }
    
    public BiologicalDirectory(Integer pk, String kingdomCn, String kingdomLatin, String phylumCn, String phylumLatin, String classCn, String classLatin, String orderCn, String orderLatin, String familyCn, String familyLatin, String genusCn, String genusLatin, String speciesCn, String speciesLatin, String auditor, String directoryVersion) {
        this.pk = pk;
        this.kingdomCn = kingdomCn;
        this.kingdomLatin = kingdomLatin;
        this.phylumCn = phylumCn;
        this.phylumLatin = phylumLatin;
        this.classCn = classCn;
        this.classLatin = classLatin;
        this.orderCn = orderCn;
        this.orderLatin = orderLatin;
        this.familyCn = familyCn;
        this.familyLatin = familyLatin;
        this.genusCn = genusCn;
        this.genusLatin = genusLatin;
        this.speciesCn = speciesCn;
        this.speciesLatin = speciesLatin;
        this.auditor = auditor;
        this.directoryVersion = directoryVersion;
    }
    
    
    public Integer getPk() {
        return pk;
    }
    
    public void setPk(Integer pk) {
        this.pk = pk;
    }
    
    public String getKingdomCn() {
        return kingdomCn;
    }
    
    public void setKingdomCn(String kingdomCn) {
        this.kingdomCn = kingdomCn;
    }
    
    public String getKingdomLatin() {
        return kingdomLatin;
    }
    
    public void setKingdomLatin(String kingdomLatin) {
        this.kingdomLatin = kingdomLatin;
    }
    
    public String getPhylumCn() {
        return phylumCn;
    }
    
    public void setPhylumCn(String phylumCn) {
        this.phylumCn = phylumCn;
    }
    
    public String getPhylumLatin() {
        return phylumLatin;
    }
    
    public void setPhylumLatin(String phylumLatin) {
        this.phylumLatin = phylumLatin;
    }
    
    public String getClassCn() {
        return classCn;
    }
    
    public void setClassCn(String classCn) {
        this.classCn = classCn;
    }
    
    public String getClassLatin() {
        return classLatin;
    }
    
    public void setClassLatin(String classLatin) {
        this.classLatin = classLatin;
    }
    
    public String getOrderCn() {
        return orderCn;
    }
    
    public void setOrderCn(String orderCn) {
        this.orderCn = orderCn;
    }
    
    public String getOrderLatin() {
        return orderLatin;
    }
    
    public void setOrderLatin(String orderLatin) {
        this.orderLatin = orderLatin;
    }
    
    public String getFamilyCn() {
        return familyCn;
    }
    
    public void setFamilyCn(String familyCn) {
        this.familyCn = familyCn;
    }
    
    public String getFamilyLatin() {
        return familyLatin;
    }
    
    public void setFamilyLatin(String familyLatin) {
        this.familyLatin = familyLatin;
    }
    
    public String getGenusCn() {
        return genusCn;
    }
    
    public void setGenusCn(String genusCn) {
        this.genusCn = genusCn;
    }
    
    public String getGenusLatin() {
        return genusLatin;
    }
    
    public void setGenusLatin(String genusLatin) {
        this.genusLatin = genusLatin;
    }
    
    public String getSpeciesCn() {
        return speciesCn;
    }
    
    public void setSpeciesCn(String speciesCn) {
        this.speciesCn = speciesCn;
    }
    
    public String getSpeciesLatin() {
        return speciesLatin;
    }
    
    public void setSpeciesLatin(String speciesLatin) {
        this.speciesLatin = speciesLatin;
    }
    
    public String getAuditor() {
        return auditor;
    }
    
    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }
    
    public String getDirectoryVersion() {
        return directoryVersion;
    }
    
    public void setDirectoryVersion(String directoryVersion) {
        this.directoryVersion = directoryVersion;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BiologicalDirectory that = (BiologicalDirectory) o;
        return Objects.equals(pk, that.pk) && Objects.equals(kingdomCn, that.kingdomCn) && Objects.equals(kingdomLatin, that.kingdomLatin) && Objects.equals(phylumCn, that.phylumCn) && Objects.equals(phylumLatin, that.phylumLatin) && Objects.equals(classCn, that.classCn) && Objects.equals(classLatin, that.classLatin) && Objects.equals(orderCn, that.orderCn) && Objects.equals(orderLatin, that.orderLatin) && Objects.equals(familyCn, that.familyCn) && Objects.equals(familyLatin, that.familyLatin) && Objects.equals(genusCn, that.genusCn) && Objects.equals(genusLatin, that.genusLatin) && Objects.equals(speciesCn, that.speciesCn) && Objects.equals(speciesLatin, that.speciesLatin) && Objects.equals(auditor, that.auditor) && Objects.equals(directoryVersion, that.directoryVersion);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(pk, kingdomCn, kingdomLatin, phylumCn, phylumLatin, classCn, classLatin, orderCn, orderLatin, familyCn, familyLatin, genusCn, genusLatin, speciesCn, speciesLatin, auditor, directoryVersion);
    }
    
    
    @Override
    public String toString() {
        return "BiologicalDirectory{" +
                "pk=" + pk +
                ", KingdomCn='" + kingdomCn + '\'' +
                ", KingdomLatin='" + kingdomLatin + '\'' +
                ", PhylumCn='" + phylumCn + '\'' +
                ", PhylumLatin='" + phylumLatin + '\'' +
                ", ClassCn='" + classCn + '\'' +
                ", ClassLatin='" + classLatin + '\'' +
                ", OrderCn='" + orderCn + '\'' +
                ", OrderLatin='" + orderLatin + '\'' +
                ", FamilyCn='" + familyCn + '\'' +
                ", FamilyLatin='" + familyLatin + '\'' +
                ", GenusCn='" + genusCn + '\'' +
                ", GenusLatin='" + genusLatin + '\'' +
                ", SpeciesCn='" + speciesCn + '\'' +
                ", SpeciesLatin='" + speciesLatin + '\'' +
                ", auditor='" + auditor + '\'' +
                ", directoryVersion='" + directoryVersion + '\'' +
                '}';
    }
}