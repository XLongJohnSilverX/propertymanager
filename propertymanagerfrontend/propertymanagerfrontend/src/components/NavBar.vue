<template>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="">PropertyManager</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="">Properties</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Work Orders</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Help</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>
<script>

export default {
    name: 'NavBar',
    props: {

    }
    
}

</script>