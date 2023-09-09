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
      String KingdomCn;
      String KingdomLatin;
      String PhylumCn;
      String PhylumLatin;
      String ClassCn;
      String ClassLatin;
      String OrderCn;
      String OrderLatin;
      String FamilyCn;
      String FamilyLatin;
      String GenusCn;
      String GenusLatin;
      String SpeciesCn;
      String SpeciesLatin;
      String auditor;
      String directoryVersion;
    
    
    public BiologicalDirectory() {
    }
    
    public BiologicalDirectory(Integer pk, String kingdomCn, String kingdomLatin, String phylumCn, String phylumLatin, String classCn, String classLatin, String orderCn, String orderLatin, String familyCn, String familyLatin, String genusCn, String genusLatin, String speciesCn, String speciesLatin, String auditor, String directoryVersion) {
        this.pk = pk;
        KingdomCn = kingdomCn;
        KingdomLatin = kingdomLatin;
        PhylumCn = phylumCn;
        PhylumLatin = phylumLatin;
        ClassCn = classCn;
        ClassLatin = classLatin;
        OrderCn = orderCn;
        OrderLatin = orderLatin;
        FamilyCn = familyCn;
        FamilyLatin = familyLatin;
        GenusCn = genusCn;
        GenusLatin = genusLatin;
        SpeciesCn = speciesCn;
        SpeciesLatin = speciesLatin;
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
        return KingdomCn;
    }
    
    public void setKingdomCn(String kingdomCn) {
        KingdomCn = kingdomCn;
    }
    
    public String getKingdomLatin() {
        return KingdomLatin;
    }
    
    public void setKingdomLatin(String kingdomLatin) {
        KingdomLatin = kingdomLatin;
    }
    
    public String getPhylumCn() {
        return PhylumCn;
    }
    
    public void setPhylumCn(String phylumCn) {
        PhylumCn = phylumCn;
    }
    
    public String getPhylumLatin() {
        return PhylumLatin;
    }
    
    public void setPhylumLatin(String phylumLatin) {
        PhylumLatin = phylumLatin;
    }
    
    public String getClassCn() {
        return ClassCn;
    }
    
    public void setClassCn(String classCn) {
        ClassCn = classCn;
    }
    
    public String getClassLatin() {
        return ClassLatin;
    }
    
    public void setClassLatin(String classLatin) {
        ClassLatin = classLatin;
    }
    
    public String getOrderCn() {
        return OrderCn;
    }
    
    public void setOrderCn(String orderCn) {
        OrderCn = orderCn;
    }
    
    public String getOrderLatin() {
        return OrderLatin;
    }
    
    public void setOrderLatin(String orderLatin) {
        OrderLatin = orderLatin;
    }
    
    public String getFamilyCn() {
        return FamilyCn;
    }
    
    public void setFamilyCn(String familyCn) {
        FamilyCn = familyCn;
    }
    
    public String getFamilyLatin() {
        return FamilyLatin;
    }
    
    public void setFamilyLatin(String familyLatin) {
        FamilyLatin = familyLatin;
    }
    
    public String getGenusCn() {
        return GenusCn;
    }
    
    public void setGenusCn(String genusCn) {
        GenusCn = genusCn;
    }
    
    public String getGenusLatin() {
        return GenusLatin;
    }
    
    public void setGenusLatin(String genusLatin) {
        GenusLatin = genusLatin;
    }
    
    public String getSpeciesCn() {
        return SpeciesCn;
    }
    
    public void setSpeciesCn(String speciesCn) {
        SpeciesCn = speciesCn;
    }
    
    public String getSpeciesLatin() {
        return SpeciesLatin;
    }
    
    public void setSpeciesLatin(String speciesLatin) {
        SpeciesLatin = speciesLatin;
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
        return Objects.equals(pk, that.pk) && Objects.equals(KingdomCn, that.KingdomCn) && Objects.equals(KingdomLatin, that.KingdomLatin) && Objects.equals(PhylumCn, that.PhylumCn) && Objects.equals(PhylumLatin, that.PhylumLatin) && Objects.equals(ClassCn, that.ClassCn) && Objects.equals(ClassLatin, that.ClassLatin) && Objects.equals(OrderCn, that.OrderCn) && Objects.equals(OrderLatin, that.OrderLatin) && Objects.equals(FamilyCn, that.FamilyCn) && Objects.equals(FamilyLatin, that.FamilyLatin) && Objects.equals(GenusCn, that.GenusCn) && Objects.equals(GenusLatin, that.GenusLatin) && Objects.equals(SpeciesCn, that.SpeciesCn) && Objects.equals(SpeciesLatin, that.SpeciesLatin) && Objects.equals(auditor, that.auditor) && Objects.equals(directoryVersion, that.directoryVersion);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(pk, KingdomCn, KingdomLatin, PhylumCn, PhylumLatin, ClassCn, ClassLatin, OrderCn, OrderLatin, FamilyCn, FamilyLatin, GenusCn, GenusLatin, SpeciesCn, SpeciesLatin, auditor, directoryVersion);
    }
    
    
    @Override
    public String toString() {
        return "BiologicalDirectory{" +
                "pk=" + pk +
                ", KingdomCn='" + KingdomCn + '\'' +
                ", KingdomLatin='" + KingdomLatin + '\'' +
                ", PhylumCn='" + PhylumCn + '\'' +
                ", PhylumLatin='" + PhylumLatin + '\'' +
                ", ClassCn='" + ClassCn + '\'' +
                ", ClassLatin='" + ClassLatin + '\'' +
                ", OrderCn='" + OrderCn + '\'' +
                ", OrderLatin='" + OrderLatin + '\'' +
                ", FamilyCn='" + FamilyCn + '\'' +
                ", FamilyLatin='" + FamilyLatin + '\'' +
                ", GenusCn='" + GenusCn + '\'' +
                ", GenusLatin='" + GenusLatin + '\'' +
                ", SpeciesCn='" + SpeciesCn + '\'' +
                ", SpeciesLatin='" + SpeciesLatin + '\'' +
                ", auditor='" + auditor + '\'' +
                ", directoryVersion='" + directoryVersion + '\'' +
                '}';
    }
}