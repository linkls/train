<template>
	<a-layout id="components-layout-demo-top-side">
		<the-header-view></the-header-view>
    <a-layout>
      <the-sider-view></the-sider-view>
      <a-layout-content
          :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
      >
        <router-view></router-view>
      </a-layout-content>
    </a-layout>
		
		<a-layout-footer style="text-align: center">
			12306
		</a-layout-footer>
	</a-layout>
</template>
<script>
	import {
		UserOutlined,
		LaptopOutlined,
		NotificationOutlined
	} from '@ant-design/icons-vue';
	import {
		defineComponent,
		ref
	} from 'vue';
	import TheHeaderView from "@/components/the-header.vue";
	import TheSiderView from "@/components/the-sider.vue";
	export default defineComponent({
		components: {
			TheSiderView,
			TheHeaderView,
			UserOutlined,
			LaptopOutlined,
			NotificationOutlined,
		},
		setup() {
			return {
				selectedKeys1: ref(['2']),
				selectedKeys2: ref(['1']),
				openKeys: ref(['sub1']),
			};
		},
	});
</script>
<style>
	#components-layout-demo-top-side .logo {
		float: left;
		width: 120px;
		height: 31px;
		margin: 16px 24px 16px 0;
		background: rgba(255, 255, 255, 0.3);
	}

	.ant-row-rtl #components-layout-demo-top-side .logo {
		float: right;
		margin: 16px 0 16px 24px;
	}

	.site-layout-background {
		background: #fff;
	}
</style>