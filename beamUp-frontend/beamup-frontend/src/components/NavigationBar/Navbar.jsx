import React from 'react';
import styled from 'styled-components';
import {Home,InfoCircle} from 'styled-icons/fa-solid';


const Navbar = () => {
    return(
        <div>
            <NavbarContent>
                <h1>BeamUp</h1>
                <ul>
                    
                    <li>
                        <Home/>
                        Home</li>
                    <li>
                        <InfoCircle/>
                        About</li>
                </ul>
            </NavbarContent>
        </div>
    )
}

const NavbarContent = styled.div`
    background: transparent;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding:50px;
    padding-top:10px;
    h1{
        color:white;
        
    }
    
    ul{
        margin-right:30px;
        display:flex;
        li{
            padding:10px;
            font-size:20px;
            color:white;
            display:flex;
            align-items:center;

            svg{
                color:white;
                width:20px;
                margin-right:10px;
            }
        }

    }
`

export default Navbar;