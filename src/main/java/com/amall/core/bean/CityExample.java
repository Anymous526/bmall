package com.amall.core.bean;

import java.util.ArrayList;
import java.util.List;

public class CityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCityidIsNull() {
            addCriterion("cityid is null");
            return (Criteria) this;
        }

        public Criteria andCityidIsNotNull() {
            addCriterion("cityid is not null");
            return (Criteria) this;
        }

        public Criteria andCityidEqualTo(Long value) {
            addCriterion("cityid =", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotEqualTo(Long value) {
            addCriterion("cityid <>", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThan(Long value) {
            addCriterion("cityid >", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThanOrEqualTo(Long value) {
            addCriterion("cityid >=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThan(Long value) {
            addCriterion("cityid <", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThanOrEqualTo(Long value) {
            addCriterion("cityid <=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidIn(List<Long> values) {
            addCriterion("cityid in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotIn(List<Long> values) {
            addCriterion("cityid not in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidBetween(Long value1, Long value2) {
            addCriterion("cityid between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotBetween(Long value1, Long value2) {
            addCriterion("cityid not between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andFletterIsNull() {
            addCriterion("fletter is null");
            return (Criteria) this;
        }

        public Criteria andFletterIsNotNull() {
            addCriterion("fletter is not null");
            return (Criteria) this;
        }

        public Criteria andFletterEqualTo(String value) {
            addCriterion("fletter =", value, "fletter");
            return (Criteria) this;
        }

        public Criteria andFletterNotEqualTo(String value) {
            addCriterion("fletter <>", value, "fletter");
            return (Criteria) this;
        }

        public Criteria andFletterGreaterThan(String value) {
            addCriterion("fletter >", value, "fletter");
            return (Criteria) this;
        }

        public Criteria andFletterGreaterThanOrEqualTo(String value) {
            addCriterion("fletter >=", value, "fletter");
            return (Criteria) this;
        }

        public Criteria andFletterLessThan(String value) {
            addCriterion("fletter <", value, "fletter");
            return (Criteria) this;
        }

        public Criteria andFletterLessThanOrEqualTo(String value) {
            addCriterion("fletter <=", value, "fletter");
            return (Criteria) this;
        }

        public Criteria andFletterLike(String value) {
            addCriterion("fletter like", value, "fletter");
            return (Criteria) this;
        }

        public Criteria andFletterNotLike(String value) {
            addCriterion("fletter not like", value, "fletter");
            return (Criteria) this;
        }

        public Criteria andFletterIn(List<String> values) {
            addCriterion("fletter in", values, "fletter");
            return (Criteria) this;
        }

        public Criteria andFletterNotIn(List<String> values) {
            addCriterion("fletter not in", values, "fletter");
            return (Criteria) this;
        }

        public Criteria andFletterBetween(String value1, String value2) {
            addCriterion("fletter between", value1, value2, "fletter");
            return (Criteria) this;
        }

        public Criteria andFletterNotBetween(String value1, String value2) {
            addCriterion("fletter not between", value1, value2, "fletter");
            return (Criteria) this;
        }

        public Criteria andProvIsNull() {
            addCriterion("prov is null");
            return (Criteria) this;
        }

        public Criteria andProvIsNotNull() {
            addCriterion("prov is not null");
            return (Criteria) this;
        }

        public Criteria andProvEqualTo(String value) {
            addCriterion("prov =", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvNotEqualTo(String value) {
            addCriterion("prov <>", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvGreaterThan(String value) {
            addCriterion("prov >", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvGreaterThanOrEqualTo(String value) {
            addCriterion("prov >=", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvLessThan(String value) {
            addCriterion("prov <", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvLessThanOrEqualTo(String value) {
            addCriterion("prov <=", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvLike(String value) {
            addCriterion("prov like", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvNotLike(String value) {
            addCriterion("prov not like", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvIn(List<String> values) {
            addCriterion("prov in", values, "prov");
            return (Criteria) this;
        }

        public Criteria andProvNotIn(List<String> values) {
            addCriterion("prov not in", values, "prov");
            return (Criteria) this;
        }

        public Criteria andProvBetween(String value1, String value2) {
            addCriterion("prov between", value1, value2, "prov");
            return (Criteria) this;
        }

        public Criteria andProvNotBetween(String value1, String value2) {
            addCriterion("prov not between", value1, value2, "prov");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andSuocityIsNull() {
            addCriterion("suocity is null");
            return (Criteria) this;
        }

        public Criteria andSuocityIsNotNull() {
            addCriterion("suocity is not null");
            return (Criteria) this;
        }

        public Criteria andSuocityEqualTo(String value) {
            addCriterion("suocity =", value, "suocity");
            return (Criteria) this;
        }

        public Criteria andSuocityNotEqualTo(String value) {
            addCriterion("suocity <>", value, "suocity");
            return (Criteria) this;
        }

        public Criteria andSuocityGreaterThan(String value) {
            addCriterion("suocity >", value, "suocity");
            return (Criteria) this;
        }

        public Criteria andSuocityGreaterThanOrEqualTo(String value) {
            addCriterion("suocity >=", value, "suocity");
            return (Criteria) this;
        }

        public Criteria andSuocityLessThan(String value) {
            addCriterion("suocity <", value, "suocity");
            return (Criteria) this;
        }

        public Criteria andSuocityLessThanOrEqualTo(String value) {
            addCriterion("suocity <=", value, "suocity");
            return (Criteria) this;
        }

        public Criteria andSuocityLike(String value) {
            addCriterion("suocity like", value, "suocity");
            return (Criteria) this;
        }

        public Criteria andSuocityNotLike(String value) {
            addCriterion("suocity not like", value, "suocity");
            return (Criteria) this;
        }

        public Criteria andSuocityIn(List<String> values) {
            addCriterion("suocity in", values, "suocity");
            return (Criteria) this;
        }

        public Criteria andSuocityNotIn(List<String> values) {
            addCriterion("suocity not in", values, "suocity");
            return (Criteria) this;
        }

        public Criteria andSuocityBetween(String value1, String value2) {
            addCriterion("suocity between", value1, value2, "suocity");
            return (Criteria) this;
        }

        public Criteria andSuocityNotBetween(String value1, String value2) {
            addCriterion("suocity not between", value1, value2, "suocity");
            return (Criteria) this;
        }

        public Criteria andDomainIsNull() {
            addCriterion("domain is null");
            return (Criteria) this;
        }

        public Criteria andDomainIsNotNull() {
            addCriterion("domain is not null");
            return (Criteria) this;
        }

        public Criteria andDomainEqualTo(String value) {
            addCriterion("domain =", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotEqualTo(String value) {
            addCriterion("domain <>", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThan(String value) {
            addCriterion("domain >", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThanOrEqualTo(String value) {
            addCriterion("domain >=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThan(String value) {
            addCriterion("domain <", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThanOrEqualTo(String value) {
            addCriterion("domain <=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLike(String value) {
            addCriterion("domain like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotLike(String value) {
            addCriterion("domain not like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainIn(List<String> values) {
            addCriterion("domain in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotIn(List<String> values) {
            addCriterion("domain not in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainBetween(String value1, String value2) {
            addCriterion("domain between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotBetween(String value1, String value2) {
            addCriterion("domain not between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andPinyinIsNull() {
            addCriterion("pinyin is null");
            return (Criteria) this;
        }

        public Criteria andPinyinIsNotNull() {
            addCriterion("pinyin is not null");
            return (Criteria) this;
        }

        public Criteria andPinyinEqualTo(String value) {
            addCriterion("pinyin =", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotEqualTo(String value) {
            addCriterion("pinyin <>", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThan(String value) {
            addCriterion("pinyin >", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("pinyin >=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThan(String value) {
            addCriterion("pinyin <", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThanOrEqualTo(String value) {
            addCriterion("pinyin <=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLike(String value) {
            addCriterion("pinyin like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotLike(String value) {
            addCriterion("pinyin not like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinIn(List<String> values) {
            addCriterion("pinyin in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotIn(List<String> values) {
            addCriterion("pinyin not in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinBetween(String value1, String value2) {
            addCriterion("pinyin between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotBetween(String value1, String value2) {
            addCriterion("pinyin not between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andSuoxieIsNull() {
            addCriterion("suoxie is null");
            return (Criteria) this;
        }

        public Criteria andSuoxieIsNotNull() {
            addCriterion("suoxie is not null");
            return (Criteria) this;
        }

        public Criteria andSuoxieEqualTo(String value) {
            addCriterion("suoxie =", value, "suoxie");
            return (Criteria) this;
        }

        public Criteria andSuoxieNotEqualTo(String value) {
            addCriterion("suoxie <>", value, "suoxie");
            return (Criteria) this;
        }

        public Criteria andSuoxieGreaterThan(String value) {
            addCriterion("suoxie >", value, "suoxie");
            return (Criteria) this;
        }

        public Criteria andSuoxieGreaterThanOrEqualTo(String value) {
            addCriterion("suoxie >=", value, "suoxie");
            return (Criteria) this;
        }

        public Criteria andSuoxieLessThan(String value) {
            addCriterion("suoxie <", value, "suoxie");
            return (Criteria) this;
        }

        public Criteria andSuoxieLessThanOrEqualTo(String value) {
            addCriterion("suoxie <=", value, "suoxie");
            return (Criteria) this;
        }

        public Criteria andSuoxieLike(String value) {
            addCriterion("suoxie like", value, "suoxie");
            return (Criteria) this;
        }

        public Criteria andSuoxieNotLike(String value) {
            addCriterion("suoxie not like", value, "suoxie");
            return (Criteria) this;
        }

        public Criteria andSuoxieIn(List<String> values) {
            addCriterion("suoxie in", values, "suoxie");
            return (Criteria) this;
        }

        public Criteria andSuoxieNotIn(List<String> values) {
            addCriterion("suoxie not in", values, "suoxie");
            return (Criteria) this;
        }

        public Criteria andSuoxieBetween(String value1, String value2) {
            addCriterion("suoxie between", value1, value2, "suoxie");
            return (Criteria) this;
        }

        public Criteria andSuoxieNotBetween(String value1, String value2) {
            addCriterion("suoxie not between", value1, value2, "suoxie");
            return (Criteria) this;
        }

        public Criteria andIffocusIsNull() {
            addCriterion("iffocus is null");
            return (Criteria) this;
        }

        public Criteria andIffocusIsNotNull() {
            addCriterion("iffocus is not null");
            return (Criteria) this;
        }

        public Criteria andIffocusEqualTo(Boolean value) {
            addCriterion("iffocus =", value, "iffocus");
            return (Criteria) this;
        }

        public Criteria andIffocusNotEqualTo(Boolean value) {
            addCriterion("iffocus <>", value, "iffocus");
            return (Criteria) this;
        }

        public Criteria andIffocusGreaterThan(Boolean value) {
            addCriterion("iffocus >", value, "iffocus");
            return (Criteria) this;
        }

        public Criteria andIffocusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("iffocus >=", value, "iffocus");
            return (Criteria) this;
        }

        public Criteria andIffocusLessThan(Boolean value) {
            addCriterion("iffocus <", value, "iffocus");
            return (Criteria) this;
        }

        public Criteria andIffocusLessThanOrEqualTo(Boolean value) {
            addCriterion("iffocus <=", value, "iffocus");
            return (Criteria) this;
        }

        public Criteria andIffocusIn(List<Boolean> values) {
            addCriterion("iffocus in", values, "iffocus");
            return (Criteria) this;
        }

        public Criteria andIffocusNotIn(List<Boolean> values) {
            addCriterion("iffocus not in", values, "iffocus");
            return (Criteria) this;
        }

        public Criteria andIffocusBetween(Boolean value1, Boolean value2) {
            addCriterion("iffocus between", value1, value2, "iffocus");
            return (Criteria) this;
        }

        public Criteria andIffocusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("iffocus not between", value1, value2, "iffocus");
            return (Criteria) this;
        }

        public Criteria andQuhaoIsNull() {
            addCriterion("quhao is null");
            return (Criteria) this;
        }

        public Criteria andQuhaoIsNotNull() {
            addCriterion("quhao is not null");
            return (Criteria) this;
        }

        public Criteria andQuhaoEqualTo(String value) {
            addCriterion("quhao =", value, "quhao");
            return (Criteria) this;
        }

        public Criteria andQuhaoNotEqualTo(String value) {
            addCriterion("quhao <>", value, "quhao");
            return (Criteria) this;
        }

        public Criteria andQuhaoGreaterThan(String value) {
            addCriterion("quhao >", value, "quhao");
            return (Criteria) this;
        }

        public Criteria andQuhaoGreaterThanOrEqualTo(String value) {
            addCriterion("quhao >=", value, "quhao");
            return (Criteria) this;
        }

        public Criteria andQuhaoLessThan(String value) {
            addCriterion("quhao <", value, "quhao");
            return (Criteria) this;
        }

        public Criteria andQuhaoLessThanOrEqualTo(String value) {
            addCriterion("quhao <=", value, "quhao");
            return (Criteria) this;
        }

        public Criteria andQuhaoLike(String value) {
            addCriterion("quhao like", value, "quhao");
            return (Criteria) this;
        }

        public Criteria andQuhaoNotLike(String value) {
            addCriterion("quhao not like", value, "quhao");
            return (Criteria) this;
        }

        public Criteria andQuhaoIn(List<String> values) {
            addCriterion("quhao in", values, "quhao");
            return (Criteria) this;
        }

        public Criteria andQuhaoNotIn(List<String> values) {
            addCriterion("quhao not in", values, "quhao");
            return (Criteria) this;
        }

        public Criteria andQuhaoBetween(String value1, String value2) {
            addCriterion("quhao between", value1, value2, "quhao");
            return (Criteria) this;
        }

        public Criteria andQuhaoNotBetween(String value1, String value2) {
            addCriterion("quhao not between", value1, value2, "quhao");
            return (Criteria) this;
        }

        public Criteria andPointIsNull() {
            addCriterion("point is null");
            return (Criteria) this;
        }

        public Criteria andPointIsNotNull() {
            addCriterion("point is not null");
            return (Criteria) this;
        }

        public Criteria andPointEqualTo(String value) {
            addCriterion("point =", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotEqualTo(String value) {
            addCriterion("point <>", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThan(String value) {
            addCriterion("point >", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThanOrEqualTo(String value) {
            addCriterion("point >=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThan(String value) {
            addCriterion("point <", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThanOrEqualTo(String value) {
            addCriterion("point <=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLike(String value) {
            addCriterion("point like", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotLike(String value) {
            addCriterion("point not like", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointIn(List<String> values) {
            addCriterion("point in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotIn(List<String> values) {
            addCriterion("point not in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointBetween(String value1, String value2) {
            addCriterion("point between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotBetween(String value1, String value2) {
            addCriterion("point not between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andDoneIsNull() {
            addCriterion("done is null");
            return (Criteria) this;
        }

        public Criteria andDoneIsNotNull() {
            addCriterion("done is not null");
            return (Criteria) this;
        }

        public Criteria andDoneEqualTo(Boolean value) {
            addCriterion("done =", value, "done");
            return (Criteria) this;
        }

        public Criteria andDoneNotEqualTo(Boolean value) {
            addCriterion("done <>", value, "done");
            return (Criteria) this;
        }

        public Criteria andDoneGreaterThan(Boolean value) {
            addCriterion("done >", value, "done");
            return (Criteria) this;
        }

        public Criteria andDoneGreaterThanOrEqualTo(Boolean value) {
            addCriterion("done >=", value, "done");
            return (Criteria) this;
        }

        public Criteria andDoneLessThan(Boolean value) {
            addCriterion("done <", value, "done");
            return (Criteria) this;
        }

        public Criteria andDoneLessThanOrEqualTo(Boolean value) {
            addCriterion("done <=", value, "done");
            return (Criteria) this;
        }

        public Criteria andDoneIn(List<Boolean> values) {
            addCriterion("done in", values, "done");
            return (Criteria) this;
        }

        public Criteria andDoneNotIn(List<Boolean> values) {
            addCriterion("done not in", values, "done");
            return (Criteria) this;
        }

        public Criteria andDoneBetween(Boolean value1, Boolean value2) {
            addCriterion("done between", value1, value2, "done");
            return (Criteria) this;
        }

        public Criteria andDoneNotBetween(Boolean value1, Boolean value2) {
            addCriterion("done not between", value1, value2, "done");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}