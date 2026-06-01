package com.comdog.c2d.dto; // 💡 본인의 실제 프로젝트 패키지 경로에 맞게 수정하세요!

import java.time.LocalDateTime;

public class MemberDto {
    
    // 💡 DB의 member_id는 클래스 내부 경계를 활용해 깔끔하게 'id'로 명명합니다.
    private Long id;            // 사용자 고유번호
    private String email;       // 이메일
    private String password;    // 비밀번호
    private String name;        // 사용자 실명
    private String phone;       // 연락처
    
    // 💡 ENUM 타입은 자바에서 String으로 처리하는 것이 매핑하기 가장 편합니다.
    private String userType;    // 회원 구분 ('PERSONAL', 'BUSINESS')
    
    // 💡 TINYINT(1)은 자바의 Boolean(true/false)과 완벽하게 호환됩니다.
    private Boolean isSubscribed; // 구독 여부 (0: false, 1: true)
    
    // 💡 DATETIME은 자바 8 버전 이후 표준인 LocalDateTime을 사용합니다.
    private LocalDateTime createdAt; // 가입일

    // ==========================================
    // 기본 생성자 (MyBatis나 스프링이 객체를 만들 때 필수)
    // ==========================================
    public MemberDto() {
    }

    // ==========================================
    // Getter & Setter 메서드
    // ==========================================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Boolean getIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(Boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}