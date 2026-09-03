import { useState } from 'react'
import '../styles/pio.css'
import reactIcono from "../assets/react.svg"
import repioSVG from "../assets/repio.svg"
import commentSVG from "../assets/comment.svg"
import likeSVG from "../assets/like.svg"
import viewSVG from "../assets/view.svg";

function Pio(){
    const [likes, setLikes] = useState(0);
    const [repios, setRepios] = useState(0);

    return (
        <>
            <div className="pio-container">
                <div className="pio">
                    <div className="pio-left-column">
                        <div className="pio-img">
                            <img src={reactIcono} alt="logo" />
                        </div>
                    </div>
                    <div className="pio-right-column">
                        <div className="pio-tittle">
                            <span className="nick"><strong>Xetloz</strong></span>
                            <span className="userAndTime">@xetloz1001 - 10min</span>
                        </div>
                        <div className="pio-body">
                            <p>Japón es una sociedad bastante más restrictiva que China. 
                                Pero bastante más. Ved vídeos y entrevistas de chinos viviendo en 
                                Japón: estudiantes, trabajadores, turistas...
                                Y todos amáis Japón. Amariáis también China sin los trillones 
                                de propaganda que invierten los anglosajones.</p> 
                        </div>
                        <div className="pio-footer">
                            <div className="pio-comments-count">
                                <img className="footer-icons" src={commentSVG} alt="" />
                                <span>6</span>
                            </div>
                            <div className="pio-repios-count">
                                <img className="footer-icons" src={repioSVG} alt="" />
                                <span>10</span>
                            </div>
                            <div className="pio-likes-count">
                                <img className="footer-icons" src={likeSVG} alt="" />
                                <span>250</span>
                            </div>
                            <div className="pio-views-count">
                                <img className="footer-icons" src={viewSVG} alt="" />
                                <span>2 mil</span>
                            </div>
                        </div>
                    </div>                    
                </div>
            </div>
        </>
    )
}

export default Pio