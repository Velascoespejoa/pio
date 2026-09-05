import '../styles/rightbar.css'

function Rightbar(){

    return (
        <>
            <div className="rightbar-container">
                <label className="search">
                    <svg
                        width="20"
                        height="20"
                        viewBox="0 0 24 24"
                        fill="none"
                    >
                        <circle
                            cx="11"
                            cy="11"
                            r="7"
                            stroke="currentColor"
                            strokeWidth="2"
                        />
                        <path
                            d="M16 16L21 21"
                            stroke="currentColor"
                            strokeWidth="2"
                            strokeLinecap="round"
                        />
                    </svg>

                    <input type="text" placeholder="Buscar"/>
                </label>

                <div className="tendencias">
                    <div className="tendencias-title">
                        <span>Tendencias</span>
                    </div>
                    <div className="tendencias-body">
                        <div className="tendencias-item">
                           <div>
                                <span>React</span>
                           </div>
                        </div>
                         <div className="tendencias-item">
                           <div>
                                <span>Angular</span>
                           </div>
                        </div>
                         <div className="tendencias-item">
                           <div>
                                <span>NodeJS</span>
                           </div>
                        </div>
                         <div className="tendencias-item">
                           <div>
                                <span>ExpressJS</span>
                           </div>
                        </div>
                         <div className="tendencias-item">
                           <div>
                                <span>VueJS</span>
                           </div>
                        </div>
                        
                    </div>
                </div>

                <div className="sugerencias-container">
                    <div className="sugerencias-title">
                        <span>A quién seguir</span>
                    </div>
                    <div className="sugerencias-body">
                        <div className="seguir-a">
                            <div className="seguir-avatar">
                                <img src="src/assets/avatares/1.jpeg" alt="img" />
                            </div>

                            <div className="seguir-info">
                                <span className="seguir-nombre">
                                    <strong>Juaniko</strong>
                                </span>

                                <span className="seguir-user">
                                    @juan986
                                </span>
                            </div>

                            <div className="seguir-boton">
                                <button>Seguir</button>
                            </div>
                        </div>

                        <div className="seguir-a">
                            <div className="seguir-avatar">
                                <img src="src/assets/avatares/2.jpeg" alt="img" />
                            </div>

                            <div className="seguir-info">
                                <span className="seguir-nombre">
                                    <strong>Rodri Perez velasco</strong>
                                </span>

                                <span className="seguir-user">
                                    @peroz312
                                </span>
                            </div>

                            <div className="seguir-boton">
                                <button>Seguir</button>
                            </div>
                        </div>

                        <div className="seguir-a">
                            <div className="seguir-avatar">
                                <img src="src/assets/avatares/3.jpeg" alt="img" />
                            </div>

                            <div className="seguir-info">
                                <span className="seguir-nombre">
                                    <strong>Homero</strong>
                                </span>

                                <span className="seguir-user">
                                    @Illisiaco
                                </span>
                            </div>

                            <div className="seguir-boton">
                                <button>Seguir</button>
                            </div>
                        </div>
                    </div>
                    <div className="sugerencias-footer">

                    </div>
                </div>
            </div>
        </>
    )
    
}

export default Rightbar