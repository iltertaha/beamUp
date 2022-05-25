import React from 'react';
import BeamedLinks from './BeamedLinks/BeamedLinks';
import Navbar from './NavigationBar/Navbar'
import styled from 'styled-components';

const BeamUp = () => {


    const Sections = [
        {
            id:0,
            path:"/",
            components: [
                {
                    id:0,
                    name:"Navigation Bar",
                    component: <Navbar/>
                },
                {
                    id:1,
                    name:"BeamedLinks",
                    component: <BeamedLinks/>
                }
            ]
        }
    ]

    return(
        <BeamUpRender>
            {Sections[0].components.map(
                (component_,index) => {
                    return component_.component
                }
            )}
        </BeamUpRender>
    )
}

const BeamUpRender = styled.div`
background-image: radial-gradient( circle farthest-corner at 92.3% 71.5%,  rgba(83,138,214,1) 0%, rgba(134,231,214,1) 90% );width:100vw;
max-height:100vh;
wifth:100vw;
height:100vh;
`
export default BeamUp;