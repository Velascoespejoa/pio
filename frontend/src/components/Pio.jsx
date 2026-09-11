import '../styles/pio.css'


function Pio({nick, user, time, text, comments, repios, likes, views, profileImgUrl }){

    return (
        <>
            <div className="pio-container">
                <div className="pio">
                    <div className="pio-left-column">
                        <div className="pio-img">
                            <img src={`http://localhost:8080/uploads/avatars/${profileImgUrl}`} alt="logo" />
                        </div>
                    </div>
                    <div className="pio-right-column">
                        <div className="pio-tittle">
                            <span className="nick"><strong>{nick}</strong></span>
                            <span className="userAndTime"> @{user} - {time}</span>
                        </div>
                        <div className="pio-body">
                            <p>{text}</p> 
                        </div>
                        <div className="pio-footer">
                            <div className="pio-comments-count">
                                <svg viewBox="0 0 32 32" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:sketch="http://www.bohemiancoding.com/sketch/ns">
                                    
                                    <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" sketch:type="MSPage">
                                        <g id="Icon-Set" sketch:type="MSLayerGroup" transform="translate(-308.000000, -255.000000)" fill="#000000">
                                            <path d="M327.494,279.633 L324,284 L320.506,279.633 C314.464,278.355 309.992,273.863 309.992,268.501 C309.992,262.146 316.264,256.994 324,256.994 C331.736,256.994 338.008,262.146 338.008,268.501 C338.008,273.863 333.536,278.355 327.494,279.633 L327.494,279.633 Z M324,255 C315.163,255 308,261.143 308,268.72 C308,274.969 312.877,280.232 319.542,281.889 L324,287.001 L328.459,281.889 C335.123,280.232 340,274.969 340,268.72 C340,261.143 332.837,255 324,255 L324,255 Z" id="comment-4" sketch:type="MSShapeGroup">
                                            </path>
                                        </g>
                                    </g>
                                </svg>
                                <span>{comments}</span>
                            </div>
                            <div className="pio-repios-count">                               
                                <svg
                                fill="#000000"
                                viewBox="0 0 24 24"
                                id="retweet-round"
                                xmlns="http://www.w3.org/2000/svg"
                                className="icon line"
                                >
                                <path
                                    id="primary"
                                    d="M18.46,7.11A6,6,0,0,1,15,18H10"
                                    style={{
                                    fill: "none",
                                    stroke: "rgb(0, 0, 0)",
                                    strokeLinecap: "round",
                                    strokeLinejoin: "round",
                                    strokeWidth: 1.5,
                                    }}
                                />

                                <polyline
                                    id="primary-2"
                                    data-name="primary"
                                    points="12 20 10 18 12 16"
                                    style={{
                                    fill: "none",
                                    stroke: "rgb(0, 0, 0)",
                                    strokeLinecap: "round",
                                    strokeLinejoin: "round",
                                    strokeWidth: 1.5,
                                    }}
                                />

                                <path
                                    id="primary-3"
                                    data-name="primary"
                                    d="M5.54,16.89A6,6,0,0,1,9,6h5"
                                    style={{
                                    fill: "none",
                                    stroke: "rgb(0, 0, 0)",
                                    strokeLinecap: "round",
                                    strokeLinejoin: "round",
                                    strokeWidth: 1.5,
                                    }}
                                />

                                <polyline
                                    id="primary-4"
                                    data-name="primary"
                                    points="12 4 14 6 12 8"
                                    style={{
                                    fill: "none",
                                    stroke: "rgb(0, 0, 0)",
                                    strokeLinecap: "round",
                                    strokeLinejoin: "round",
                                    strokeWidth: 1.5,
                                    }}
                                />
                                </svg>
                                <span>{repios}</span>
                            </div>
                            <div className="pio-likes-count">
                                <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M8 10V20M8 10L4 9.99998V20L8 20M8 10L13.1956 3.93847C13.6886 3.3633 14.4642 3.11604 15.1992 3.29977L15.2467 3.31166C16.5885 3.64711 17.1929 5.21057 16.4258 6.36135L14 9.99998H18.5604C19.8225 9.99998 20.7691 11.1546 20.5216 12.3922L19.3216 18.3922C19.1346 19.3271 18.3138 20 17.3604 20L8 20" stroke="#000000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
                                </svg>
                                <span>{likes}</span>
                            </div>
                            <div className="pio-views-count">
                                <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <circle cx="12" cy="12" r="3.5" stroke="#222222"/>
                                    <path d="M21 12C21 12 20 4 12 4C4 4 3 12 3 12" stroke="#222222"/>
                                </svg>
                                <span>{views}</span>
                            </div>
                        </div>
                    </div>                    
                </div>
            </div>
        </>
    )
}

export default Pio