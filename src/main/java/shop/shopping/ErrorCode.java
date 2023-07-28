package shop.shopping;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATE_USER_ID(400,"ACCOUNT-001","계정명이 중복된 경우");

    private final int status;
    private final String code;
    private  final String description;




}
