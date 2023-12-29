package com.example.springboot.login;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.springboot.login.domain.Member;
import com.example.springboot.login.domain.MemberDTO;
import com.example.springboot.login.domain.ResultVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {

    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
    private final LoginMapper mapper;

    @Override
    public ResultVO<MemberDTO> doLogin(Map<String, String> param) throws Exception {
        ResultVO<MemberDTO> resultVO = new ResultVO<>();
        MemberDTO member = convertToDto(mapper.selectMemberById(param));
        if (member != null) {
            String password = param.get("PASSWORD");
            if (password.equals(member.getPassword())) {
                resultVO.setData(member);
            } else {
                resultVO.setError(true);
                resultVO.setMessage("Wrong Password!");
            }
        } else {
            resultVO.setError(true);
            resultVO.setMessage("Not Member!");
        }
        return resultVO;
    }

    @Override
    public ResultVO<String> signup(Map<String, String> param) throws Exception {
        ResultVO<String> resultVO = new ResultVO<>();
        Member member = mapper.selectMemberById(param);
        if (member == null) {
            mapper.insertMember(param);
            resultVO.setData("Welcome " + param.get("NAME"));
        } else {
            resultVO.setError(true);
            resultVO.setMessage("Dup Member!");
        }
        return resultVO;
    }

    @Override
    public ResultVO<List<MemberDTO>> getAllMembers() {
        ResultVO<List<MemberDTO>> resultVO = new ResultVO<>();
        List<Member> result = mapper.selectAllMembers();
        resultVO.setData(result.stream().map(this::convertToDto).collect(Collectors.toList()));
        return resultVO;
    }

    private MemberDTO convertToDto(Member entity) {
        if(entity == null) return null;
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, MemberDTO.class);
    }

}
