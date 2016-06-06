<div class="container-fluid">
            <div class="row">

                <div id="monCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#monCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#monCarousel" data-slide-to="1"></li>
                        <li data-target="#monCarousel" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">

                        <div class="item active">
                            <img src="/pizzeria-admin-app/images/Carousel/Carousel1.jpg" alt="Pizzeria" width="1980" height="500">
                            <div class="carousel-caption">
                                <h1>La Florentina</h1>
                                <p>L'italie est dans votre pizza !</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="/pizzeria-admin-app/images/Carousel/Carousel2.jpg" alt="Pizzeria" width="1980" height="500">
                            <div class="carousel-caption">
                                <h1>Nos pizzas</h1>
                                <p>Il y en � pour tous les go�ts</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="/pizzeria-admin-app/images/Carousel/Carousel3.jpg" alt="Pizzeria" width="1980" height="500">
                            <div class="carousel-caption">
                                <h1>Four � bois</h1>
                                <p>Quoi de mieux qu'un foir � bois pour faire de bonnes pizzas</p>
                            </div>
                        </div>
                    </div>

                    

                    <!-- Fl�ches de contr�le -->
                    <a class="left carousel-control" href="#monCarousel" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Pr�c�dent</span>
                    </a>
                    <a class="right carousel-control" href="#monCarousel" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Suivant</span>
                    </a>
                </div>
                </div>
                <!-- D�but de la barre de navigation -->
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <!-- Barre de navigation pour smartphones -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#maNavBar">
                            </button>
                        </div>

                        <!-- Barre de navigation pour ordinateurs -->
                        <div class="collapse navbar-collapse" id="maNavBar">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="<%=request.getContextPath()%>/pizzas/list">Liste Pizza</a></li>
                            </ul>				 
                        </div><!-- /.navbar-collapse -->
                    </div><!-- /.container-fluid -->
                </nav>
            </div>