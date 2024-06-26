import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useRecoilValue } from 'recoil';
import { isVisibleState } from '../recoil/atoms';
import LoginModal from '../modals/LoginModal';
import { getLoginInfo } from '../function/LoginState';
import styled from 'styled-components';

const NavigationContainer = styled.nav`

`;

const NavItem = styled.button`
  display: flex;
  align-items: center;
  margin-bottom: 10px;
  margin-left: 0px;
  border: none;
  background-color: transparent;
  height: 40px;
  width: 100%;
  transition: height 0.3s ease;
  &:hover {
    background-color: #ECF7F7;
    height: 40px;
  }
`;

const NavText = styled.p`
  margin-left: 15px;
  font-size: 18px;
`;

const NavLink = styled(Link)`
  color: black;
  text-decoration-line:none;
`;

const NavIcon = styled.img`
  width: ${({ $primary }) => $primary ? '27px' : '23px'};
  margin-left: 25px;
  position: relative;
  right: ${({ $isSidebarOpen }) => $isSidebarOpen ? '0px' : '-188px'};
`;


export default function Navigate() {

  const navigate = useNavigate();
  const [showModal, setShowModal] = useState(false);
  const isSidebarOpen = useRecoilValue(isVisibleState);

  const handleNavigate = async (path) => {
    try {
      const { loginStatus } = await getLoginInfo();
      if (loginStatus) {
        navigate(path);
      } else {
        setShowModal(true);
      }
    } catch (error) {
      console.error('Failed to retrieve login information', error);
    }
  };

  return (
    <NavigationContainer>
    <NavLink to='/exams/create'>
        <NavItem>
          <NavIcon src="/img/시험지제작소.svg" alt="icon Image" $isSidebarOpen={isSidebarOpen} />
          <NavText>시험지 제작소</NavText>
        </NavItem>
      </NavLink>
      
      <NavItem onClick={() => handleNavigate('/exams')}>
          <NavIcon src="/img/문제관리소.svg" alt="icon Image" $isSidebarOpen={isSidebarOpen} $primary="true"/>
          <NavText>문제 관리소</NavText>
      </NavItem>

      <NavItem onClick={() => handleNavigate('/workbooks')}>
        <NavIcon src="/img/시험지저장소.svg" alt="icon Image" $isSidebarOpen={isSidebarOpen} />
        <NavText>시험지 저장소</NavText>
      </NavItem>

      {showModal && <LoginModal onClose={() => setShowModal(false)} />}
    </NavigationContainer>
  );
}